from collections import deque

def main():
    N = int(input())
    commands = [input().strip() for _ in range(N)]
    
    queue = deque()
    results = [] 

    for command in commands:
        if command.startswith('+'):
            _, i = command.split()
            queue.append(int(i))
        elif command.startswith('*'):
            _, i = command.split()
            goblin = int(i)
            middle_index = len(queue) // 2 
            queue.append(None)
            for j in range(len(queue) - 1, middle_index, -1):
                queue[j] = queue[j - 1]
            queue[middle_index] = goblin 
        elif command == '-':
            if queue:
                goblin = queue.popleft()
                results.append(goblin)

    for result in results:
        print(result)

if __name__ == "__main__":
    main()
