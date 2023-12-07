//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/12/06.
//  백준 2170: 선 긋기
//  메모리: 124332 KB
//  시간: 844 ms

import Foundation

final class FileIO {
    private let buffer: Data
    private var index: Int = 0

    init(fileHandle: FileHandle = FileHandle.standardInput) {
        self.buffer = try! fileHandle.readToEnd()! // 인덱스 범위 넘어가는 것 방지
    }

    @inline(__always) private func read() -> UInt8 {
        defer {
            index += 1
        }
        guard index < buffer.count else { return 0 }

        return buffer[index]
    }

    @inline(__always) func readInt() -> Int {
        var sum = 0
        var now = read()
        var isPositive = true
        while now == 10
                || now == 32 { now = read() } // 공백과 줄바꿈 무시
        if now == 45 { isPositive.toggle(); now = read() } // 음수 처리
        while now >= 48, now <= 57 {
            sum = sum * 10 + Int(now-48)
            now = read()
        }
        return sum * (isPositive ? 1:-1)
    }

    @inline(__always) func readString() -> String {
        var str = ""
        var now = read()

        while now == 10
                || now == 32 { now = read() } // 공백과 줄바꿈 무시

        while now != 10
                && now != 32 && now != 0 {
            str += String(bytes: [now], encoding: .ascii)!
            now = read()
        }

        return str
    }
}

let fileIO = FileIO()
let n = fileIO.readInt()
var lines: [(s: Int, e: Int)] = []
for _ in 0..<n {
    let s = fileIO.readInt()
    let e = fileIO.readInt()
    lines.append((s, e))
}

lines.sort {
    if $0.s != $1.s {
        return $0.s < $1.s
    } else {
        return $0.e < $1.e
    }
}

var left = lines[0].s, right = lines[0].e
var result = 0
for i in 1..<n {
    let line = lines[i]
    if right >= lines[i].e {
        continue
    }

    if line.s <= right && right < line.e {
        right = line.e
    } else if right < line.e {
        result += right - left
        left = line.s
        right = line.e
    }
}
result += right - left

print(result)
