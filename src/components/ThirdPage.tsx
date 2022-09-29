import { TextField } from "@mui/material";
import { FC, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Book } from "./Book";


interface ThirdPageProps {

}

export const ThirdPage: FC<ThirdPageProps> = (props: ThirdPageProps) => {
    const[name, setName] = useState('');
    const[price, setPrice] = useState('');
    const textStyle = {with: "30px", margin: "5px"}
    const[books, setBooks] = useState([]);
    const navigate = useNavigate();

    const onSave = (e: any) => {
        e.preventDefault();
        const bookSave = {name, price}
        console.log(bookSave)
        fetch("http://localhost:8080/bookQuery", {
            method: "POST",
            headers: {
              'Content-Type': 'application/json',
              'Access-Control-Allow-Origin': 'http://localhost:8080/bookQuery'
            },
            body: JSON.stringify(bookSave)
        }).then(() => {
            console.log("Added")
        })
    };

    useEffect(() => {
        fetch("http://localhost:8080/bookQuery/all", {
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8080/bookQuery/all',
                'Access-Control-Request-Method': 'GET',
                'Access-Control-Allow-Headers': 'Content-Type'
            }
        }).then(res => {
            return res.json();
        }).then(data => {
            setBooks(data);
            console.log(data);
        });
    });

    const onAnotherPage = () => {
        navigate("/");
    }

    return (
        <>
            <div className="head">
                <button className="first_button" onClick={onAnotherPage}>
                    Wróć do głównej strony
                </button>
            </div>
            <div className="background">
                <div className="firstColumn_secondPage">
                    Swtórz książke:
                    <ul>
                        <TextField id="outlined-basic" label="Nazwa Książki" variant="outlined" value={name} 
                        onChange={(e: any) => setName(e.target.value)} style={textStyle} />
                    </ul>
                    <ul>
                        <TextField id="outlined-basic" label="Cena" variant="outlined" value={price} 
                        onChange={(e: any) => setPrice(e.target.value)} style={textStyle}/>
                    </ul>
                    <button className="first_button" onClick={onSave}> Stwórz </button>
                </div>
                <div className="secondColumn_secondPage">
                    Edytuj dane:
                    {books.map(book => (
                        <Book book={book}/>
                    ))}
                </div>
            </div>
        </>
    )
}