//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/11/13.
//////  백준 7576: 토마토
//////  메모리: 130728 KB
//////  시간: 324 ms

import Foundation

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]

let MN = readLine()!.split(separator: " ").map { Int($0)! }
let (N, M) = (MN[0], MN[1])
var tomato: [[Int]] = []

for _ in 0..<M {
    tomato.append(readLine()!.split(separator: " ").map { Int($0)! })
}

struct Queue<T> {
    var leftStack: [T] = []
    var rightStack: [T] = []

    var isEmpty: Bool {
        return leftStack.isEmpty && rightStack.isEmpty
    }

    mutating func enqueue(_ item: T) {
        rightStack.append(item)
    }

    mutating func dequeue() -> T? {
        if leftStack.isEmpty {
            leftStack = rightStack.reversed()
            rightStack.removeAll()
        }
        return leftStack.popLast()
    }
}

func bfs(_ queue: inout Queue<[Int]>, _ tomato: inout [[Int]]) {
    while !queue.isEmpty {
        guard let current = queue.dequeue() else { return }
        let x = current[0]
        let y = current[1]

        for i in 0..<4 {
            let nx = x + dx[i]
            let ny = y + dy[i]

            if nx >= 0 && nx < tomato.count && ny >= 0 && ny < tomato[0].count && tomato[nx][ny] == 0 {
                tomato[nx][ny] = tomato[x][y] + 1
                queue.enqueue([nx, ny])
            }
        }
    }
}

var queue = Queue<[Int]>()
for i in 0..<M {
    for j in 0..<N {
        if tomato[i][j] == 1 {
            queue.enqueue([i, j])
        }
    }
}

bfs(&queue, &tomato)

var day = 0
for row in tomato {
    if row.contains(0) {
        day = -1
        break
    }
    day = max(day, row.max()! - 1)
}

print(day)
