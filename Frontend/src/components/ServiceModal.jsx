import React from "react";
import { FaTimes } from "react-icons/fa";
import "../styles/ServiceModal.css";

const ServiceModal = ({ service, onClose }) => {
  if (!service) return null;

  return (
    <div className="modal-overlay">
      <div className="service-modal">
        <div className="modal-header">
          <h2>{service.name}</h2>
          <button className="close-btn" onClick={onClose}>
            <FaTimes />
          </button>
        </div>
        <div className="modal-content">
          <div className="service-image">
            <img src={service.img} alt={service.name} />
          </div>
          <div className="service-details">
            <div className="service-description">
              <h3>Description</h3>
              <p>{service.description || "No description available"}</p>
            </div>
            <div className="service-pricing">
              <h3>Pricing</h3>
              <p>Starting from ₹{service.basePrice}/hour</p>
              {service.packages && (
                <div className="packages">
                  <h4>Packages:</h4>
                  <ul>
                    {service.packages.map((pkg, index) => (
                      <li key={index}>
                        <span className="package-name">{pkg.name}</span>
                        <span className="package-price">₹{pkg.price}</span>
                        <p className="package-desc">{pkg.description}</p>
                      </li>
                    ))}
                  </ul>
                </div>
              )}
            </div>
            <div className="service-actions">
              <button className="book-btn">Book Now</button>
              <button className="cart-btn">Add to Cart</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ServiceModal;