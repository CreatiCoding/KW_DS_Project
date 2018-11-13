SURC = *.cpp *.h
EXEC = run.o
CC = g++
all: compile start

compile: $(SURC)
	$(CC) -g -o $(EXEC) $^
start:
	./run.o
clean:
	rm -rf $(EXEC)
	rm -rf *.bak
	rm -rf *~

