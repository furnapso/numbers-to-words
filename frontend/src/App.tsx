import "./App.css";
import "./assets/mvp.css";
import React, {useState} from "react";
import backendService from "./service/backendService.ts";

function App() {
    const [number, setNumber] = useState<string>("");
    const [error, setError] = useState<string | null>(null);
    const [loading, setLoading] = useState(false);
    const [result, setResult] = useState<string | null>(null);

    const buttonEnabled = number.trim() !== "" && !loading;

    async function handleSubmit(e: React.FormEvent<HTMLFormElement>) {
        e.preventDefault();

        setLoading(true);

        if (!number.trim()) {
            setError("Please enter a number.");
            return;
        }

        const parsedNumber = parseFloat(number);
        if (isNaN(parsedNumber)) {
            setError("Invalid number. Please enter a valid number.");
            return;
        }

        setError(null);
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div className={"flex w-auto justify-center items-center flex-col"}>
                    <header>Convert Numbers to Words</header>
                    <label htmlFor={"number"}>Number</label>
                    <input
                        name={"number"}
                        onChange={e => setNumber(e.target.value)}
                        required
                        type={"text"}
                    />
                    <button disabled={!buttonEnabled}>Convert</button>
                    {error && <span style={{color: "red"}}>{error}</span>}
                    {loading && <img src={"/loading.svg"} alt={"loading"}/>}
                </div>
            </form>
        </div>
    );
}

export default App;
