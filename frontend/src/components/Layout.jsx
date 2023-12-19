import PropTypes from 'prop-types';
import Navbar from "./Navbar";

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