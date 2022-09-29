import { FC, useState } from "react";
import './App.css';


interface BookViewProps {
    book: any
}

export const BookView : FC<BookViewProps> = (props: BookViewProps) => {

    return (
        <div className="book">
            <div className="block_in_book">
                <ul>Nazwa Książki: {props.book.name}</ul>
                <ul>Cena: {props.book.price} zł</ul>
            </div>
            <div className="block_under_book">
            </div>
        </div>
    )
}