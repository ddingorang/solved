n, g = input().split(' ')
players = set()
for i in range(int(n)):
    players.add(input())

if g == 'Y' :
    print(len(players))
elif g == 'F' :
    print(len(players) // 2)
elif g == 'O' :
    print(len(players) // 3)