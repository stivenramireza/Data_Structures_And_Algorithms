PACKAGES = modulos arbol main 

# Java compiler
JAVAC = javac
JVM = 1.8

BIN = ./bin/

SRC = ./src/

# Java compiler flags
JAVAFLAGS = -g -d $(BIN) -cp $(SRC) -target $(JVM)

# Creating a .class file
COMPILE = $(JAVAC) $(JAVAFLAGS)

EMPTY = 

JAVA_FILES = $(subst $(SRC), $(EMPTY), $(wildcard $(SRC)*.java))

ifdef PACKAGES
PACKAGEDIRS = $(addprefix $(SRC), $(PACKAGES))
PACKAGEFILES = $(subst $(SRC), $(EMPTY), $(foreach DIR, $(PACKAGEDIRS), $(wildcard $(DIR)/*.java)))
ALL_FILES = $(PACKAGEFILES) $(JAVA_FILES)
else
#ALL_FILES = $(wildcard $(SRC).java)
ALL_FILES = $(JAVA_FILES)
endif

CLASS_FILES = $(subst $(SRC), $(BIN), $(ALL_FILES:.java=.class))
#CLASS_FILES = $(ALL_FILES:.java=.class)

# "make". 

all : $(addprefix $(BIN), $(CLASS_FILES))

$(BIN)%.class : $(SRC)%.java
	$(COMPILE) $<

clean :
	rm -rf $(BIN)* *~
