def solution(board):
    oc = 0
    xc = 0
    obg = 0
    xbg = 0
    answer = 1
    valid = True
    
    # o, x 갯수 세기
    for i in range(3) :
        for j in range(3) :
            if board[i][j] == 'O' :
                oc += 1
            elif board[i][j] == 'X' :
                xc += 1
    
    # 두 문자의 개수 차이가 2 이상이면 무효
    if oc-xc >= 2 or xc - oc > 0 :
        answer = 0
        valid = False
    
    if valid :
        # 가로방향 빙고 확인
        for i in range(3) :
            if board[i] == 'OOO' :
                obg += 1
            elif board[i] == 'XXX' :
                xbg += 1

        # 세로방향 빙고 확인
        for j in range(3) :
            if board[0][j] + board[1][j] + board[2][j] == 'OOO' :
                obg += 1
            elif board[0][j] + board[1][j] + board[2][j] == 'XXX' :
                xbg += 1

        # 대각선 방향 빙고 확인
        if board[0][0] + board[1][1] + board[2][2] == 'OOO' :
            obg += 1
        elif board[0][0] + board[1][1] + board[2][2] == 'XXX' :
            xbg += 1
        if board[2][0] + board[1][1] + board[0][2] == 'OOO' :
            obg += 1
        elif board[2][0] + board[1][1] + board[0][2] == 'XXX' :
            xbg += 1
    
        # 두 빙고의 개수가 2 이상이면 무효임 =>  빙고가 하나 만들어졌을 때 게임이 종료
        if obg == 1 and xbg == 1 :
            answer = 0
        elif obg == 1 and oc == xc : 
            answer = 0
        elif xbg == 1 and oc > xc :
            answer = 0
    
    return answer