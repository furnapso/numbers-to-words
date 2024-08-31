import "./App.css";
import "./assets/mvp.css";

function App() {
    return (
        <div>
            <form>
                <header>Convert Numbers to Words</header>
                <label htmlFor={"number"}>Number</label>
                <input name={"number"}/>
                <button>Convert</button>
            </form>
        </div>
    );
}

export default App;
