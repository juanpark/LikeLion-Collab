FROM ubuntu:24.04
RUN apt-get update && apt-get install -y bash
WORKDIR /app

#copy shell script
COPY run.sh .

#grant privileges
RUN chmod +x run.sh

# run container and script
CMD ["bash", "./run.sh"]

# docker build -t case1-shell-app .
# docker run --rm case1-shell-app
