from collections import deque
import itertools

def gsp(placements,N):
    start = None
    end = None
    for i in range(N):
        for j in range(N):
            if placements[i][j]=='S':
                start = (i,j)
            elif placements[i][j]=='D':
                end = (i,j)

    queue = deque([(start,0)])
    visited  ={start}

    while queue:
        (x,y),dist = queue.popleft()
        if placements[x][y] == 'D':
            return dist

        for nx,ny in [(x+1,y),(x-1,y),(x,y+1),(x,y-1)]:
            if 0 <= nx<N and 0<=ny<N and (nx,ny) not in visited and placements[nx][ny]!= 'T':
                visited.add((nx,ny))
                queue.append(((nx,ny),dist+1))
    return float('inf')
def getsh(placements,N,M):
    shts = []
    for i in range(0, N, M):
        for j in range(0, N, M):
            sheet = []
            for x in range(M):
                row = []
                for y in range(M):
                    row.append(placements[i + x][j + y])
                sheet.append(row)
            shts.append(sheet)
    return shts


def makeGr(arrNT,shts,N,M):
    placements = [["" for _ in range(N)]for _ in range(N)]
    numSht = N//M

    for idx,sidx in enumerate(arrNT):
        sheet = shts[sidx]
        bi = (idx//numSht)*M
        bj = (idx % numSht)*M

        for i in range(M):
            for j in range(M):
                placements[bi+i][bj+j] = sheet[i][j]
    return placements

def solve():
    N,M = map(int,input().split())
    orgGrid = []
    for _ in range(N):
        orgGrid.append(list(input().strip()))
    
    shts = getsh(orgGrid,N,M)
    numSht = (N//M)**2

    sst = dst = None
    for i , sheet in enumerate(shts):
        for row in sheet: 
            if 'S' in row:
                sst=i
            if 'D' in row:
                dst = i

    min_dist = float('inf')
    nums = list(range(numSht))
    nums.remove(sst)
    nums.remove(dst)

    for midPerm in itertools.permutations(nums):
        arrNT = [sst] +list(midPerm)+[dst]
        placements = makeGr(arrNT,shts,N,M)
        min_dist = min(min_dist,gsp(placements,N))
    return min_dist

if __name__ == "__main__":
    print(solve())