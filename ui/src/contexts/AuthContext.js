import { useState, createContext, useEffect, useContext} from "react";
import UserService from 'services/user/UserService';
import ServiceCaller from 'services/ServiceCaller';
import { useNavigate } from "react-router-dom";
const AuthContext = createContext();

const AuthProvider = ({children}) => {
    const [user, setUser] = useState(null);
    const [loggedIn, setLoggedIn] = useState(false);
    let navigate = useNavigate();
   /*  useEffect(() => {
            let id= localStorage.getItem("currentUserId")
                let serviceCaller = new ServiceCaller();
                UserService.getOneUser(`/user/${id}`, serviceCaller, '', (res) => {
                setUser(res);
                setLoggedIn(true);
            }, (error) => {
                console.log(error);
            })
    }, []); */

    const login = (data) => {
        setUser(data);
        localStorage.setItem("tokenKey", data.accessToken);
        localStorage.setItem("refreshKey", data.refreshToken);
        localStorage.setItem("currentUserId", data.userId);
        setLoggedIn(true);
    };
    const logout = async () => {
        setLoggedIn(false);
        console.log("logout:",loggedIn);
        setUser(null);
        localStorage.removeItem("tokenKey");
        localStorage.removeItem("refreshKey");
        localStorage.removeItem("currentUserId");
        console.log("Storage:", localStorage);
        navigate('/');
    };

    const values = {
        loggedIn,
        user,
        login,
        logout,
    }
    return <AuthContext.Provider value={values}>{children}</AuthContext.Provider>
};

const useAuth = () => useContext(AuthContext);
export { AuthProvider, useAuth }; 
 