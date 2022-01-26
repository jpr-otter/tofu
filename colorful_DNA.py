# this one gives you a colorful representation of nucleotides in DNA sequence.
# just change the path, to load a sequence of your choice.

import colorama

colorama.init()

testDNA = "ATTGCGCGATaaattttttttttttttttttttttttttttZ"
nucleos =["A", "C", "G", "T"]
DNA_reverseComplement ={'A':'T','T':'A','G':'C','C':'G'}

# the seq of your choice is read here, in this case chromosome21 of homo sapiens

human_ch21_FULL = open (r'C:\Users\Jenny\Desktop\HS_chromo21FULL.txt')
FULL_stored = human_ch21_FULL.read()
human_ch21_FULL.close()


DNA = "RRRAGCTTTTCATTCTGACTGCAACGGGCAATATGTACTCGATGCTCGACTGCTACGATCGCTGGTGTGCACAGCTATATTATATAGTGATGTGCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"


# color function, to color the nucleotides letters

seq = FULL_stored.upper()
removeThis = ['N', 'R', 'M', '\n']
for character in removeThis:
    seq = seq.replace(character,"")
  
def colored(seq):
    
    bcolors = {
	'A': '\033[41m',
        'C': '\033[42m',
        'T': '\033[43m',
        'G': '\033[44m',
	'N': '\033[45m',
        'reset': '\033[0;0m'
        #'A': '\033[92m',
        #'C': '\033[94m',
        #'T': '\033[93m',
        #'G': '\033[91m',
	#'N': '\033[90m',
        #'reset': '\033[0;0m'
    }
    
    tmpStr = ""
    dot = " "
    for nuc in seq:
        if nuc in bcolors:
            tmpStr += bcolors[nuc]  + dot
        else:
            tmpStr += bcolors ['reset'] + nuc
    return tmpStr + '\033[0;0m'
    
print ("___________________________________________________")    

print (colored(seq[0:100000]))
print (colored (DNA[0:4]))
#print('\033[2J')  # Clear screen
print('\033[31m' + 'THE END' + '\033[0m') 
