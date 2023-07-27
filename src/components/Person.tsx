import {FC} from "react";
import './App.css';

interface PersonProps {
    person: any
}

export const Person : FC<PersonProps> = (props: PersonProps) => {

    return (
        <div className="person">
            <div className="block_in_person">
                <ul>Imie: {props.person.firstName}</ul>
                <ul>Nazwisko: {props.person.lastName}</ul>
            </div>
        </div>
    )
}