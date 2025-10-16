# CS230_Project_1

### Jake Terry <br/> Elden Johnson


## Partition
Partition will return two Hashmaps, one containing instructions, value/address, and addressing type, keyed with an index. The other containing the label, keyed with the index it exists. 


Example output: 

```
// if exists
Detected label: next_let:

Instructions:
0: [LDBA, 0x0041, i]
1: [STBA, 0xFC16, d]
2: [ADDA, 0x0001, i]
3: [CPBA, 0x005B, i]
4: [BRNE, next_let, i]
5: [STOP]
6: [.END]

// if they exist
Branches: 
1: [next_let]
```


So: next_let keyed index 1 -> instructions[1] will be the next_let instructions

With this we can compare any branch instructions to its label

so for index 1 we have a next_let that would be broken like this after partitioning

```
List<String> branch_line = instructions.get(1);
String instruct_set = branch_line.get(0);     // "STBA" --> F_
String value = branch_line.get(1);   // "0xFC16" --> FC16
String addressing = branch_line.get(2);   // "i' --> _1

// result --> F1FC16 --> 3 byes 
```

if it exist in branches, we just run that index of instructions

```
0000  D00041          LDBA    0x0041,i    
0003  F1FC16 next_let:STBA    0xFC16,d    
0006  600001          ADDA    0x0001,i    
0009  B0005B          CPBA    0x005B,i    
000C  1A0003          BRNE    next_let    

000F  00              STOP                

0010                  .END  
```

We must keep track of the bytes used for each instruction set, here we can see that next_let begins on 0003, and the BRNE instructions reference the 0003