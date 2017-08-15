# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""
from random import randint
import os       
                
def std(size):
    
    ints = [randint(-99999,99999) for i in range(size)]
    sints = sorted(ints)
    rints = list(reversed(sints))
    
    dirPath = os.path.dirname(__file__)
    
    #Unsorted
    filename = os.path.join(dirPath, "Inputs/Input{}.txt".format(size))
    with open(filename, 'w') as fout:
        for i in range(size):
            if i != size-1:
                fout.write("{}\n".format(ints[i]))
            else:
                fout.write("{}".format(ints[i]))
             
    #Sorted
    filename = os.path.join(dirPath, "Inputs/Input{}Sorted.txt".format(size))    
    with open(filename, 'w') as fout:
        for i in range(len(sints)):
            if i != size-1:
                fout.write("{}\n".format(sints[i]))
            else:
                fout.write("{}".format(sints[i]))
           
    #Reversed
    filename = os.path.join(dirPath, "Inputs/Input{}Reversed.txt".format(size))
    with open(filename, 'w') as fout:
        for i in range(len(rints)):
            if i != size-1:
                fout.write("{}\n".format(rints[i]))
            else:
                fout.write("{}".format(rints[i]))
                

                
if __name__ == "__main__":
    fileSizes = [50, 500, 1000, 2000, 5000]
    
    for size in fileSizes:
        std(size)