from flask import Flask
from redis import Redis
import platform
import socket
from flask import render_template
 
app = Flask(__name__)
redis = Redis(host='redis', port=6379)
 
hostname = socket.gethostname()
@app.route('/')
def hello():
 
    count = redis.incr('hits')
#    count = 1
    displaystring =  " " + str(count) +" Times and now from the host  " + hostname
 
#    return 'Hello World! I have been seen {}  .\n'.format (displaystring )
    return render_template('demopage.html', displaystring=displaystring)
if __name__ == "__main__":
    app.run(host="0.0.0.0", debug=True)
