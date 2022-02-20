# this is a precursor to feed numbers into a processing script that visualizes numbers with colored blocks.
# i thought this would be a nice way to visualize genetic data
# keep in mind though that 40million nucleotides of this human chromosome is way to large. if one nucleotide would be one pixel
# you d roughly need 6300x6300 to get the whole chromosome in one frame.


# read open write the files
human_ch21_FULL = open (r'C:\Users\Jenny\Desktop\Studium\1. Semester\GDBI files\HS_chromo21FULL.txt')
f2 =  open ('C:\\Users\\Jenny\\Desktop\\Studium\\1. Semester\\GDBI files\\test3.txt', 'w')
f1 = human_ch21_FULL.read()
f1 = f1.upper()

# removes all the gunk residue of the genetic database
removeThis = ['N', 'R', 'M', '\n']
for character in removeThis:
    f1 = f1.replace(character,"")

# turns the letters into number. kinda cheating because i cannot write the processing script myself
checkWords = ("A","T","C","G")
repWords = ("0","1","2","4")

for line in f1:
    for check, rep in zip(checkWords, repWords):
        line = line.replace(check, rep)
    f2.write(line)


f2.close()
# donezo!
print ("done")
