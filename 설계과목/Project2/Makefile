SURC = *.cc *.h
EXEC = run
CC = g++
all: $(SURC)
	cp ./test/myString.h ./
	$(CC) -o $(EXEC) $^
clean:
	rm -rf $(EXEC)
	rm -rf *.bak
	rm -rf *~

