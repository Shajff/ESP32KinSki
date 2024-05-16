import { Button } from 'bootstrap';
import './App.css';
import React, {useEffect, useState} from 'react';
import SockJsClient from 'react-stomp';
import {Tooltip,YAxis,XAxis,CartesianGrid,LineChart,Legend,Line} from 'recharts'
function App() {
  const SOCKET_URL = 'http://localhost:8080/ws-message';


  const initialData = [
    {
      name: '2024-04-23T18:40:50',
      left_ski: 0,
      right_ski: 0
    },
    {
      name: '2024-04-23T18:40:55',
      left_ski: 0,
      right_ski: 0
    },
    
  ];

  const [message,setMessage] = useState(initialData);

  const transformData = (data) => {
    const { timestamp, measurements, measurement_delay } = data;
    const { left_ski, right_ski } = measurements;

    const baseTime = new Date(timestamp).getTime();

    const result = left_ski.map((leftValue, index) => {
        const rightValue = right_ski[index];
        const newTimestamp = new Date(baseTime + index * measurement_delay * 10).toISOString();
        return {
            name: newTimestamp,
            left_ski: leftValue,
            right_ski: rightValue
        };
    });
    return result;
  };


  let onMessageReceived = (msg) => {

    const transformedData = transformData(msg);
    console.log("Transformed data",transformedData)
    setMessage(transformedData);
  }

  const resetGraph = () => {
    setMessage([]);
  }


  return (
    <div className="App">
      <div className='title'>Prikaz nagiba skija</div>
      <div className='line-chart-container'>
      <LineChart
          width={1500}
          height={500}
          data={message}
          margin={{
            top: 15,
            right: 30,
            left: 20,
            bottom: 5,
          }}
          className='line-chart'
        >
          <CartesianGrid strokeDasharray="3 3" />
          <XAxis dataKey="name" />
          <YAxis />
          <Tooltip />
          <Legend />
          <Line type="monotone" dataKey="right_ski" stroke="#8884d8" />
          <Line type="monotone" dataKey="left_ski" stroke="#82ca9d" />
        </LineChart>
      </div>
      <div>
        <SockJsClient
          url={SOCKET_URL}
          topics={['/topic/message']}
          onConnect={console.log("Connected!!")}
          onDisconnect={console.log("Disconnected!")}
          onMessage={msg => onMessageReceived(msg)}
          debug={false}
        />
        <button onClick={resetGraph}>Reset</button>
      </div>
    </div>
  );
}

export default App;
