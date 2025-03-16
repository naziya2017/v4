import { useState } from "react";
import "../styles/HomeServices.css";
import ServiceModal from "./ServiceModal";

// Enhanced services array with more details
const services = [
  {
    id: 1,
    name: "Home-Maid",
    img: "/assets/images/maid.png",
    description: "Professional home maids for cleaning, dusting, and maintaining your living space.",
    basePrice: 199,
    packages: [
      { name: "Basic Cleaning", price: 399, description: "2-hour cleaning session" },
      { name: "Deep Cleaning", price: 799, description: "4-hour deep cleaning with special attention to kitchen and bathroom" }
    ]
  },
  {
    id: 2,
    name: "Gardener",
    img: "/assets/images/gardener.png",
    description: "Expert gardeners to maintain and beautify your garden and outdoor spaces.",
    basePrice: 249,
    packages: [
      { name: "Garden Maintenance", price: 449, description: "Lawn mowing, trimming and basic garden care" },
      { name: "Garden Makeover", price: 1299, description: "Complete garden redesign and planting" }
    ]
  },
  {
    id: 3,
    name: "Chef",
    img: "/assets/images/chef.png",
    description: "Skilled chefs to prepare delicious meals for your family or special events.",
    basePrice: 349,
    packages: [
      { name: "Family Meal", price: 699, description: "Preparation of 2 meals for a family of 4" },
      { name: "Party Catering", price: 1499, description: "Catering for events up to 10 people" }
    ]
  },
  {
    id: 4,
    name: "Care Taker",
    img: "/assets/images/care_taker.png",
    description: "Compassionate care takers for elderly, children, or anyone needing assistance.",
    basePrice: 299,
    packages: [
      { name: "Daily Care", price: 599, description: "4-hour care session" },
      { name: "Full Day Care", price: 1199, description: "8-hour care with meal preparation" }
    ]
  },
  {
    id: 5,
    name: "Car Washer",
    img: "/assets/images/car_wash.png",
    description: "Professional car washing and detailing services at your doorstep.",
    basePrice: 149,
    packages: [
      { name: "Basic Wash", price: 299, description: "Exterior wash and interior vacuum" },
      { name: "Premium Detailing", price: 899, description: "Complete interior and exterior detailing" }
    ]
  },
  {
    id: 6,
    name: "Home Tutor",
    img: "/assets/images/tutor.png",
    description: "Qualified tutors for various subjects and age groups.",
    basePrice: 249,
    packages: [
      { name: "Single Session", price: 449, description: "2-hour tutoring session" },
      { name: "Monthly Package", price: 3999, description: "12 sessions per month (3 per week)" }
    ]
  },
];

const HomeServices = () => {
  const [selectedService, setSelectedService] = useState(null);

  const handleServiceClick = (serviceId) => {
    const service = services.find(s => s.id === serviceId);
    setSelectedService(service);
  };

  const closeModal = () => {
    setSelectedService(null);
  };

  return (
    <div className="home-container">
      <h2 className="home-title">Essential Services, Anytime, Anywhere</h2>
      <div className="services-box">
        <h3>Your Needs, Our Services</h3>
        <div className="services-grid">
          {services.map((service) => (
            <div
              key={service.id}
              className="service-card"
              onClick={() => handleServiceClick(service.id)}
            >
              <img src={service.img} alt={service.name} />
              <p>{service.name}</p>
            </div>
          ))}
        </div>
      </div>

      {selectedService && (
        <ServiceModal
          service={selectedService}
          onClose={closeModal}
        />
      )}
    </div>
  );
};

export default HomeServices;