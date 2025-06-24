import React from 'react';
import './TaskCard.css';

function TaskCard({ task }) {
  const { title, description, dueDate, priority, isCompleted } = task;
  
  const priorityBadgeClass = `task-priority-badge priority-${priority.toLowerCase()}`;
  const completionClass = isCompleted ? 'completed' : '';

  return (
    <div className={`taskCard ${completionClass}`}>
      <div className="task-header">
        <div className="task-info-left">
          <h3 className="task-title">{title}</h3>
          {dueDate && <p className="task-dueDate">Due: {dueDate}</p>}
        </div>
        <div className={priorityBadgeClass}>
          {priority}
        </div>
      </div>

      <div className="task-description-field">
        <p>{description}</p>
      </div>
    </div>
  );
}

export default TaskCard;
