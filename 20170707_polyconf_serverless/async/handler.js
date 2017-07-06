import fetch from 'node-fetch';

export function helloPromise(event, context, callback) {
  console.log('Running hello promise');
  fetch('https://api.github.com/users/github')
    .then(res => res.json())
    .then(json => {
      const location = json['location'];

      callback(null, {
        status: 200,
        body: JSON.stringify({ location }),
      });
    }, err => callback(null, {
      status: 200,
      error: err,
    }));
};

export async function helloAsync(event, context, callback) {
  const res = await fetch('https://api.github.com/users/github');
  const json = await res.json();
  const location = json['location'];

  callback(null, {
    status: 200,
    body: JSON.stringify({ location }),
  });
};
