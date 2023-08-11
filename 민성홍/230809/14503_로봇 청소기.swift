//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/08/09.
//// 백준 14503: 로봇 청소기
//// 메모리: 79584KB
//// 시간: 12ms

import Foundation

let NM: [Int] = readLine()!.split(separator: " ").map { Int($0)! } // 2개
let rcd: [Int] = readLine()!.split(separator: " ").map { Int($0)! } // 3개

let n: Int = NM[0]
let m: Int = NM[1]
var r: Int = rcd[0]
var c: Int = rcd[1]
var d: Int = rcd[2]

var room: Array = Array(repeating: [Int](), count: n)

for i in 0..<n {
    room[i] = readLine()!.split(separator: " ").map { Int($0)! }
}

var cleaned: Array = Array(repeating: Array(repeating: false, count: m), count: n)
var result: Int = 0

/// ex) d가 0일 때 북쪽을 바라보다가 서쪽을 바라봐야한다. 그리고 앞으로 한칸 이동하는 것이기 때문에 x좌표 왼쪽, y좌표는 그대로.
///    그래서 dx[0]이 -1, dy[0]이 0.
let dx = [-1, 0, 1, 0]
let dy = [0, 1, 0, -1]

var turnCount = 0

func cleanRoom(x: Int, y: Int, dir: Int) {
    var newX: Int = x
    var newY: Int = y
    var newD: Int = dir

    // 청소 안된 경우 청소
    if !cleaned[newX][newY] {
        cleaned[newX][newY] = true
        result += 1
    }

    // 청소 후 회전
    newD -= 1
    if newD == -1 {
        newD = 3
    }
    turnCount += 1

    // 회전 후 앞에 칸이 0이고 청소가 안된 상태면 이동
    if room[newX + dx[newD]][newY + dy[newD]] == 0 && !cleaned[newX + dx[newD]][newY + dy[newD]]{
        newX += dx[newD]
        newY += dy[newD]
        turnCount = 0
    }

    // 사방을 다 돌았는데도 청소할 곳이 없을 때
    if turnCount == 4 {
        // 뒤에가 벽이 아니면 후진
        if room[newX - dx[newD]][newY - dy[newD]] == 0 {
            newX -= dx[newD]
            newY -= dy[newD]
            turnCount = 0
        }
        // 뒤에가 벽이면 종료
        else {
            print(result)
            exit(0)
        }
    }

    cleanRoom(x: newX, y: newY, dir: newD)
}

cleanRoom(x: r, y: c, dir: d)
