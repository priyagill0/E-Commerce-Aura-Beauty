"use client";
import { useState } from "react";

export default function Signup() {
    const [form, setForm] = useState({
        firstName: "",
        lasName: "",
        email: "",
        password: "",
        address: {
            street: "",
            province: "",   
            country: "",
            zip: "",
            phone: ""
          }
    })


    const [message, setMessage] = useState("");

    const handleSubmit = async() => {
        const res = await fetch("http://localhost:8080/api/auth/signup", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(form)
        });

        if (res.ok) {
            setMessage("Account created sucessfully!");
        } else {
            setMessage("Something went wrong.")
        }
    };

    return (
        <div style={{padding:40}}>
            <h1>Create Account</h1>
            <input placeholder="First Name" onChange={e => setForm({...form, firstName: e.target.value})} />
            <input placeholder="Last Name" onChange={e => setForm({...form, lastName: e.target.value})} />
            <input placeholder="Email" onChange={e => setForm({...form, email: e.target.value})} />
            <input type="password" placeholder="Password" onChange={e => setForm({...form, password: e.target.value})} />
 
            <input placeholder="Street" onChange={e => setForm({...form, address: {...form.address, street: e.target.value}})}/>
            <input placeholder="Province" onChange={e => setForm({...form, address: {...form.address, province: e.target.value}})}/>
            <input placeholder="Country" onChange={e => setForm({...form, address: {...form.address, country: e.target.value}})} />
            <input placeholder="Zip" onChange={e => setForm({...form, address: {...form.address, zip: e.target.value}})} />
            <input placeholder="Phone" onChange={e => setForm({...form, address: {...form.address, phone: e.target.value}})} />


            <button onClick={handleSubmit}>Sign Up</button>
            <p>{message}</p>
        </div>
    );
}