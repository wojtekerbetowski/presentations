'use strict';

module.exports.hello = (event, context, callback) => {
  const response = {
    statusCode: 200,
    body: JSON.stringify({
      message: 'Hello Polyconf!',
      input: event,
    }),
  };

  callback(null, response);
};
