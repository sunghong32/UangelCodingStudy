//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 1/3/24.
////  백준 10942: 팰린드롬?
////  메모리: 124992 KB
////  시간: 292 ms

import Foundation

final class FileIO {
    private let buffer:[UInt8]
    private var index: Int = 0
    init(fileHandle: FileHandle = FileHandle.standardInput) {
        buffer = Array(try! fileHandle.readToEnd()!)+[UInt8(0)] // 인덱스 범위 넘어가는 것 방지
    }
    @inline(__always) private func read() -> UInt8 {
        defer { index += 1 }
        return buffer[index]
    }
    @inline(__always) func readInt() -> Int {
        var sum = 0
        var now = read()
        var isPositive = true
        while now == 10 || now == 32 { now = read() } // 공백과 줄바꿈 무시
        if now == 45 { isPositive.toggle(); now = read() } // 음수 처리
        while now >= 48, now <= 57 {
            sum = sum * 10 + Int(now-48)
            now = read()
        }
        return sum * (isPositive ? 1:-1)
    }
}

let fIO = FileIO()
let n = fIO.readInt()
var seq = [Int]()
for _ in 0..<n {
    seq.append(fIO.readInt())
}
var dp = Array(repeating: Array(repeating: false, count: n), count: n)

for i in stride(from: n-1, through: 0, by: -1) {
    dp[i][i] = true
    for j in stride(from: i+1, to: n, by: 1) {
        if seq[i] == seq[j] && (j - i == 1 || dp[i+1][j-1]) {
            dp[i][j] = true
        }
    }
}

let m = fIO.readInt()
var results = [String]()
for _ in 0..<m {
    let s = fIO.readInt() - 1
    let e = fIO.readInt() - 1
    results.append(dp[s][e] ? "1" : "0")
}

print(results.joined(separator: "\n"))
