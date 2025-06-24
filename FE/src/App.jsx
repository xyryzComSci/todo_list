import { useState } from 'react'
import './App.css'

function App() {
  const [tasks, setTasks] = useState([
    {
      id: 1,
      title: 'Finish React Tutorial',
      description: 'Complete the section on lists and keys.',
      dueDate: '2025-07-01',
      priority: 'HIGH',
      isCompleted: false,
    },
    {
      id: 2,
      title: 'Buy Groceries',
      description: 'Milk, Eggs, Bread, Fruits.',
      dueDate: '2025-06-25',
      priority: 'MEDIUM',
      isCompleted: false,
    },
    {
      id: 3,
      title: 'Call Aunt Mary',
      description: 'Check in on her.',
      dueDate: '2025-06-23',
      priority: 'LOW',
      isCompleted: true,
    },
  ]);


  return (
    <div>
      <h1>react-spring-todoapp</h1>
      <button>Add task</button>
      <div className='task-list-container'>
        {tasks.map((task) => (
          <TaskCard 
            id={task.id}
            task={task} 
          />
        ))}
      </div>
    </div>
  );
}


function TaskCard(task) {
  return (
    <div className='taskCard'>
      <p>{task.dueDate}</p>
      <p>{task.priority}</p>
      <p>{task.title}</p>
      <p>{task.description}</p>
    </div>
  );
}

export default App
