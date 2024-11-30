import React from "react";
import "../../../cssStyleSheets/GlassContainer.css"; // Archivo CSS para estilos

const GlassContainer = ({ children }) => {
  return <div className="glass-container">{children}</div>;
};

export default GlassContainer;