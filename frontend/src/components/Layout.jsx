import PropTypes from 'prop-types';
import Navbar from "./Navbar";

/**
 * Komponente für das Layout der Anwendung.
 * 
 * @component
 * @param {Object} props - Die Eigenschaften der Komponente.
 * @param {ReactNode} props.children - Die Kinderkomponenten, die im Layout gerendert werden sollen.
 * @returns {JSX.Element} Das gerenderte Layout.
 */
const Layout = ({ children }) => {
    return (
        <>
            <Navbar />
            <div className="container">
                {children}
            </div>
        </>
    );
};

// Wichtig!!!
Layout.propTypes = {
    children: PropTypes.node.isRequired,
};

export default Layout;