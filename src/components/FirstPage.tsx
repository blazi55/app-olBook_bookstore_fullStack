import { TextField } from "@mui/material";
import { FC, useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { PersonView } from "./PersonView";

interface FirstPageProps {

}

export const FirstPage: FC<FirstPageProps> = (props: FirstPageProps) => {
    const[firstName, setFirstName] = useState('');
    const[lastName, setLastName] = useState('');
    const[age, setAge] = useState('');
    const textStyle = {with: "30px", margin: "5px"}
    const[persons, setPersons] = useState([]);
    const navigate = useNavigate();

    const onSave = (e: any) => {
        e.preventDefault();
        const personSave = {firstName, lastName, age}
        console.log(personSave)
        fetch("http://localhost:8080/personQuery", {
            method: "POST",
            headers: {
              'Content-Type': 'application/json',
              'Access-Control-Allow-Origin': 'http://localhost:8080/personQuery'
            },
            body: JSON.stringify(personSave)
        }).then(() => {
            console.log("Added")
        })
    };

    useEffect(() => {
        fetch("http://localhost:8080/personQuery/all", {
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
                'Access-Control-Allow-Origin': 'http://localhost:8080/personQuery/all',
                'Access-Control-Request-Method': 'GET',
                'Access-Control-Allow-Headers': 'Content-Type'
            }
        }).then(res => {
            return res.json();
        }).then(data => {
            setPersons(data);
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
                    <ul>
                        <TextField id="outlined-basic" label="Imię" variant="outlined" value={firstName} 
                        onChange={(e: any) => setFirstName(e.target.value)} style={textStyle} />
                    </ul>
                    <ul>
                        <TextField id="outlined-basic" label="Nazwisko" variant="outlined" value={lastName} 
                        onChange={(e: any) => setLastName(e.target.value)} style={textStyle}/>
                    </ul>
                    <ul>
                        <TextField id="outlined-basic" label="Wiek" variant="outlined" value={age} 
                        onChange={(e: any) => setAge(e.target.value)} style={textStyle}/>
                    </ul>
                    <button className="first_button" onClick={onSave}> Stwórz </button>
                </div>
                <div className="secondColumn_secondPage">
                    {persons.map(person => (
                        <PersonView person={person}/>
                    ))}
                </div>
            </div>
        </>
    )
}