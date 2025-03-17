import { useState } from "react";
import { Link } from "react-router-dom";
import "./HomeServices.css";
import ServiceModal from "../ServiceModal/ServiceModal.jsx";
const services = [
  {
    id: 1,
    name: "Home-Maid",
    img: "/assets/images/maid.png",
    path: "/services/maid",
    subServices: [
          { id: "bathroom-kitchen", name: "Bathroom & Kitchen Cleaning", icon: "/assets/images/bathroom-kitchen-icon.png" },
          { id: "sofa-carpet", name: "Sofa & Carpet Cleaning", icon: "/assets/images/sofa-carpet-icon.png" }
        ],
  },
  {
    id: 2,
    name: "Gardener",
    img: "/assets/images/gardener.png",
    path: "/services/gardener",
        subServices: [
          { id: "lawn-mowing", name: "Lawn Mowing", icon: "/assets/images/lawn-mowing-icon.png" },
          { id: "tree-trimming", name: "Tree Trimming", icon: "/assets/images/tree-trimming-icon.png" }
        ],
  },
  {
    id: 3,
    name: "Chef",
    img: "/assets/images/chef.png",
    path: "/services/chef",
        subServices: [
          { id: "home-chef", name: "Home Chef", icon: "/assets/images/home-chef-icon.png" }
        ],
  },
  {
    id: 4,
    name: "Care Taker",
    img: "/assets/images/care_taker.png",
    path: "/services/care_taker",
    subServices:[],
  },
  {
    id: 5,
    name: "Car Washer",
    img: "/assets/images/car_wash.png",
    path: "/services/car_wash",
    subServices:[],
  },
  {
    id: 6,
    name: "Home Tutor",
    img: "/assets/images/tutor.png",
    path: "/services/home_tutor",
    subServices:[],
  },
];

const HomeServices = () => {
  const [selectedService, setSelectedService] = useState(null);
  const handleServiceClick=(serviceId)=>{
      const service=services.find(s=>s.id===serviceId);
      setSelectedService(service);
      };
  const closeModal=()=>{
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

      {/* Show Modal when a service is selected */}
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
