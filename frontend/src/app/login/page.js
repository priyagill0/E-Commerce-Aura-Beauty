"use client";
import { useState } from "react";

export default function Login() {
    const [form, setForm] = useState({
        email: "",
        password: ""
    });

    const [message, setMessage] = useState("");

    const handleLogin = async () => {
        const res = await fetch("http://localhost:8080/api/auth/login", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(form)
        });

        if (res.status === 404) {
            setMessage("Email does not exist. Please sign up first.");
            return;
        }

        if (res.status === 400) {
            setMessage("Incorrect password. Please try again.");
            return;
        }

        if (!res.ok) {
            setMessage("Login failed. Please try again.");
            return;
        }

        const user = await res.json();

        // localStorage.setItem("user", JSON.stringify({
        //     id: user.id,
        //     email: user.email,
        //     firstName: user.firstName,
        //     lastName: user.lastName
        // }));

        localStorage.setItem("user", JSON.stringify({
            id: user.id,
            email: user.email,
            firstName: user.firstName,
            lastName: user.lastName,
            address: user.address // trying to save the entire address as one object
        }));

        // const [form, setForm] = useState({
        //     firstName: "",
        //     lasName: "",
        //     email: "",
        //     password: "",
        //     address: {
        //         street: "",
        //         province: "",   
        //         country: "",
        //         zip: "",
        //         phone: ""
        //       }
        // })


        setMessage("Login successful!");

        // Redirect to homepage
        window.location.href = "/";
    };

    return (
        <div style={{padidng: 40}}>
            <h1>Login</h1>
            <input placeholder="Email" onChange={e => setForm({...form, email: e.target.value})} />
            <input type="password" placeholder="Password" onChange={e => setForm({...form, password: e.target.value})} />
            <button onClick={handleLogin}>Login</button>
            <p style={{color:"red"}}>{message}</p>
        </div>
    );
}