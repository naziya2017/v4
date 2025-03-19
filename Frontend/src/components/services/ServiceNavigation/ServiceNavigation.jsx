import React from "react";
import "./ServiceNavigation.css";
const ServiceNavigation = ({ subServices }) => {
  return (
    <div className="service-navigation">
      {subServices.map(sub => (
        <button key={sub.id} onClick={() => document.getElementById(sub.id).scrollIntoView()}>
          <img src={sub.icon} alt={sub.name} />
          <p>{sub.name}</p>
        </button>
      ))}
    </div>
  );
};

export default ServiceNavigation;
