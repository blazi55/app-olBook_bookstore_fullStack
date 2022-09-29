import { FC } from "react";
import { Background } from "./Background";


interface SecondPageProps {

}

export const SecondPage: FC<SecondPageProps> = (props: SecondPageProps) => {

    return (
        <div>
            <Background />
        </div>
    )
}