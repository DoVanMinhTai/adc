import { useEffect, useState } from "react";

export default function TestAPI() {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8087/api/product/storefront/products/productsBestSelling")
      .then(res => res.json())
      .then(setData)
      .catch(setError);
  }, []);

  return (
    <div>
      <h1>Test API Connection</h1>
      {error ? <p style={{ color: "red" }}>Error: {error.message}</p> : <pre>{JSON.stringify(data, null, 2)}</pre>}
    </div>
  );
}
