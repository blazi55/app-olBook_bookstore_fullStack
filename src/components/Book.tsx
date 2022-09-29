import { FC, useState } from "react";
import './App.css';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Button, Paper } from '@mui/material';
import { AnyARecord } from 'dns';


interface BookProps {
    book: any
}

export const Book : FC<BookProps> = (props: BookProps) => {
    const[name, setBookName] = useState('');
    const[price, setBookPrice] = useState('');
    const textStyle = {with: "30px", margin: "5px"}

    const onSave = (e: any) => {
        e.preventDefault()
        const booknew = {name, price}
        if(booknew.name != "" && booknew.price != "") {
            console.log(booknew)
            putData(booknew);
        }
    };

    const putData = (booknew: any) => {
        fetch(`http://localhost:8080/bookQuery/updateBook?id=${props.book.id}`, {
            method: "PUT",
            headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'localhost:8080/bookQuery/updateBook'
            },
            body: JSON.stringify(booknew)
        }).then((data) => {
        console.log('Success:', data);
        })
    };

    return (
        <div className="book">
            <div className="block_in_book">
                <ul>Nazwa Książki: {props.book.name}</ul>
                <ul>Cena: {props.book.price} zł</ul>
            </div>
            <div className="block_under_book">
                Zmień dane książki:
                <ul>
                    <TextField id="outlined-basic" label="Nowa nazwa" variant="outlined" value={name} onChange={(e: any) => setBookName(e.target.value)}
                    style={textStyle} />
                 </ul>
                 <ul>
                    <TextField id="outlined-basic" label="Nowa cena" variant="outlined" value={price} onChange={(e: any) => setBookPrice(e.target.value)} 
                    style={textStyle}/>
                 </ul>
                <button className="second_button" onClick={onSave}> Zapisz </button>
            </div>
        </div>
    )
}