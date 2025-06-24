import { useState } from 'react'
import './App.css'

function App() {

  return (
    <div>
      <h1>react-spring-todoapp</h1>
      <button>Add task</button>
      <TaskCard />
    </div>
  );
}


function TaskCard() {
  return (
    <div className='taskCard'>
      <p>6/24/2025</p> <p>HIGH</p>
      <p>Task Title</p>
      <p>Description</p>
    </div>
  );
}

export default App
