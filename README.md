# java-oop-park
Java parking program

# Build Docker Image
docker build -t parking-system .

# Run the Docker Container
docker run -it parking-system

# Example Commands to Interact with the System After running the container, you can interact with the parking system by issuing commands such as:

park: Parks a car, e.g., park ABC123.
checkout: Checks out a car, e.g., checkout ABC123.
available: Shows the number of available parking spots.
quit: Exits the program.