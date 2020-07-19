import React from 'react';
import './App.css';
import {GetRootContent} from './view/GetRootContent';
import {BrowserRouter as Router} from 'react-router-dom';

function App() {

  return (
    <Router>
      <div className="App">
        <main>
          <GetRootContent></GetRootContent>
        </main>
        
      </div>
    </Router>
  );
}

export default App;
