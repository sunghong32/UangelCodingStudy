//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/28.
//  백준 9663: N-Queen
//  메모리: 79508KB
//  시간: 7504ms

import Foundation

let N = Int(readLine()!)!
var board: [Int] = Array(repeating: 0, count: N)
var visited: [Bool] = Array(repeating: false, count: N)
var answer: Int = 0

func check(x: Int) -> Bool {
    for i in 0..<x {
        if board[i] == board[x] {
            return false
        }

        if abs(board[i] - board[x]) == abs(i - x) {
            return false
        }
    }

    return true
}

func dfs(x: Int) {
    if x == N {
        answer += 1
        return
    }

    for i in 0..<N {
        if visited[i] { continue }

        board[x] = i

        if check(x: x) {
            visited[i] = true
            dfs(x: x + 1)
            visited[i] = false
        }
    }
}

dfs(x: 0)

print(answer)
