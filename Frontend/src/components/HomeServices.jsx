import "../styles/HomeServices.css"; // Import CSS file

const services = [
  { id: 1, name: "Home-Maid", img: "/assets/images/maid.png" },
  { id: 2, name: "Gardener", img: "/assets/images/gardener.png" },
  { id: 3, name: "Chef", img: "/assets/images/chef.png" },
  { id: 4, name: "Care Taker", img: "/assets/images/care_taker.png" },
  { id: 5, name: "Car Washer", img: "/assets/images/car_wash.png" },
  { id: 6, name: "Home Tutor", img: "/assets/images/tutor.png" },
];

const HomeServices = () => {
  return (
    <div className="home-container">
      <h2 className="home-title">Essential Services, Anytime, Anywhere</h2>
      <div className="services-box">
        <h3>Your Needs, Our Services</h3>
        <div className="services-grid">
          {services.map((service) => (
            <div key={service.id} className="service-card">
              <img src={service.img} alt={service.name} />
              <p>{service.name}</p>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default HomeServices;
