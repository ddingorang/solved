grades = {'A+' : 4.5, 'A0' : 4.0, 'B+' : 3.5, 'B0' : 3.0, 'C+' : 2.5, 
          'C0' : 2.0, 'D+' : 1.5, 'D0' : 1.0, 'F' : 0.0}

totalpts = 0
calc = 0
for _ in range(20) :
    cn, pts, grade = input('').split(' ')
    if grade == 'P' : 
        continue
    totalpts += float(pts)
    calc = calc + grades[grade] * float(pts)

totalgrade = float(calc / totalpts)
print(totalgrade)