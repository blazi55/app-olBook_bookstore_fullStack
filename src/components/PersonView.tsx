import { TextField } from "@mui/material";
import { FC, useState } from "react";
import './App.css';


interface PersonViewProps {
    person: any
}

export const PersonView : FC<PersonViewProps> = (props: PersonViewProps) => {
    const[firstName, setFirstName] = useState('');
    const[lastName, setLastName] = useState('');
    const[age, setAge] = useState('');
    const textStyle = {with: "100px", margin: "5px"}

    const putData = (e: any) => {
        e.preventDefault()
        const personNew = {firstName, lastName, age}
        fetch(`http://localhost:8080/personQuery/update?id=${props.person.id}`, {
            method: "PUT",
            headers: {
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': 'localhost:8080/personQuery/update'
            },
            body: JSON.stringify(personNew)
        }).then((data) => {
        console.log('Success:', data);
        })
    };

    return (
        <div className="person_view">
            <div className="block_in_person">
                <ul>Imię: {props.person.firstName}</ul>
                <ul>Nazwisko: {props.person.lastName}</ul>
                <ul>Wiek: {props.person.age}</ul>
            </div>
            <div className="block_under_person">
                <>
                <ul>Zmień dane książki: </ul>
                <ul>
                    <TextField id="outlined-basic" label="Imię" variant="outlined" value={firstName} 
                    onChange={(e: any) => setFirstName(e.target.value)}
                    style={textStyle} fullWidth />
                </ul>
                <ul>
                    <TextField id="outlined-basic" label="Nazwisko" variant="outlined" value={lastName} 
                    onChange={(e: any) => setLastName(e.target.value)} 
                    style={textStyle} fullWidth/>
                </ul>
                <ul>
                    <TextField id="outlined-basic" label="Wiek" variant="outlined" value={age} 
                    onChange={(e: any) => setAge(e.target.value)} 
                    style={textStyle} fullWidth/>
                </ul>
                <button className="second_button" onClick={putData}> Zapisz </button>
                </>
            </div>
        </div>
    )
}