//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 11/21/23.
//  백준 16236: 아기 상어
//  메모리: 79524 KB
//  시간: 20 ms

import Foundation

let dx = [-1, 1, 0, 0]
let dy = [0, 0, -1, 1]

struct Fish {
    let x: Int
    let y: Int
    let dist: Int
}

struct BabyShark {
    var x: Int
    var y: Int
    var size: Int
    var eat: Int
    var time: Int
}

let N = Int(readLine()!)!
var fishbawl = [[Int]]()
var babyShark: BabyShark?

for i in 0..<N {
    let row = readLine()!.split(separator: " ").map { Int($0)! }
    if let index = row.firstIndex(of: 9) {
        babyShark = BabyShark(x: i, y: index, size: 2, eat: 0, time: 0)
    }
    fishbawl.append(row)
}

fishbawl[babyShark!.x][babyShark!.y] = 0

while true {
    var fishes = [Fish]()
    var visited = Array(repeating: Array(repeating: -1, count: N), count: N)

    var queue = [(babyShark!.x, babyShark!.y)]
    visited[babyShark!.x][babyShark!.y] = 0

    while !queue.isEmpty {
        let (x, y) = queue.removeFirst()
        for i in 0..<4 {
            let nx = x + dx[i]
            let ny = y + dy[i]

            if nx >= 0 && nx < N && ny >= 0 && ny < N {
                if visited[nx][ny] == -1 && fishbawl[nx][ny] <= babyShark!.size {
                    visited[nx][ny] = visited[x][y] + 1
                    queue.append((nx, ny))
                    if fishbawl[nx][ny] > 0 && fishbawl[nx][ny] < babyShark!.size {
                        fishes.append(Fish(x: nx, y: ny, dist: visited[nx][ny]))
                    }
                }
            }
        }
    }

    if fishes.isEmpty {
        break
    }

    fishes.sort { $0.dist != $1.dist ? $0.dist < $1.dist : ($0.x != $1.x ? $0.x < $1.x : $0.y < $1.y) }

    babyShark!.eat += 1
    if babyShark!.eat == babyShark!.size {
        babyShark!.size += 1
        babyShark!.eat = 0
    }

    babyShark!.x = fishes[0].x
    babyShark!.y = fishes[0].y
    babyShark!.time += fishes[0].dist
    fishbawl[babyShark!.x][babyShark!.y] = 0
}

print(babyShark!.time)
