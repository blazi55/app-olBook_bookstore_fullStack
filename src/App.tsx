import './components/App.css';
import { SecondPage } from './components/SecondPage';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { FirstPage } from './components/FirstPage';
import { ThirdPage } from './components/ThirdPage';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/secondPage" element={<FirstPage />} />
          <Route path="/" element={<SecondPage />} />
          <Route path="/thirdPage" element={<ThirdPage />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
