import React,{useEffect} from 'react';
import './App.css';
import {createBrowserRouter,RouterProvider} from "react-router-dom";
import routes from "./utils/routes";
import Main from './views/main/Main';
import Login from './views/auth/Login';
function App() {
  const routerStorage = createBrowserRouter([
    {
      path:"/",
      element: <Main/>,
      children: routes
    },
    {
      path:"/authen/login",
      element: <Login/>
    }
  ])
  useEffect(()=>{document.title = "E-ATP"},[])
  return (
    <div className="App">
      <RouterProvider router={routerStorage}></RouterProvider>
    </div>
  );
}

export default App;
