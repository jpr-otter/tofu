import matplotlib.pyplot as plt

def pythagorean_triples(limit):
    c, m = 0, 2
    triples = []
    while c < limit:
        for n in range(1, m):
            a = m * m - n * n
            b = 2 * m * n
            c = m * m + n * n
            if c > limit:
                break
            triples.append((a, b, c))
        m += 1
    return triples

triples = pythagorean_triples(10000)
x = [triple[0] for triple in triples]
y = [triple[1] for triple in triples]

plt.figure(figsize=(40, 40))
plt.scatter(x, y, s = 7)
plt.show()


print("First 100 Pythagorean Triples:")
print("a\tb\tc")
for triple in triples[:100]:
    print(f"{triple[0]}\t{triple[1]}\t{triple[2]}")
