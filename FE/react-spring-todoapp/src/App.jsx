import { useState } from 'react';
import './App.css';
import TaskCard from './components/TaskCard';
import TaskForm from './components/TaskForm';

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
  ]);

  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(true);
  };

  const handleCloseModal = () => {
    setIsModalOpen(false);
  };

  const handleAddTask = (newTask) => {
    const newId = tasks.length > 0 ? Math.max(...tasks.map(task => task.id)) + 1 : 1;
    
    const taskWithDefaults = {
      ...newTask,
      id: newId,
      isCompleted: false,
    };

    setTasks(prevTasks => [...prevTasks, taskWithDefaults]);
    
    handleCloseModal();
  };

  return (
    <div className="app">
      <h1>react-spring-todoapp</h1>
      <button onClick={handleOpenModal}>Add task</button>
      <div className='task-list-container'>
        {tasks.length > 0 ? (
          tasks.map((task) => (
            <TaskCard 
              key={task.id} 
              task={task} 
            />
          ))
        ) : (
          <p>No tasks to display. Click "Add task" to create one!</p>
        )}
      </div>

      {isModalOpen && (
        <TaskForm 
          onSave={handleAddTask} 
          onClose={handleCloseModal} 
        />
      )}
    </div>
  );
}

export default App;
