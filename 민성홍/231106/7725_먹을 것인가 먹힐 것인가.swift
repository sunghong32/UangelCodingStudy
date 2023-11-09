//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 2023/11/06.
////  백준 7795: 먹을 것인가 먹힐 것인가
////  메모리: 82036 KB
////  시간: 96 ms

import Foundation

let T = Int(readLine()!)!

for _ in 0..<T {
    let AB = readLine()?.split(separator: " ").map { Int($0)! }
    var A = readLine()?.split(separator: " ").map { Int($0)! }
    var B = readLine()?.split(separator: " ").map { Int($0)! }

    A!.sort()
    B!.sort()

    var result: Int = 0
    var j: Int = 0

    for i in 0..<A!.count {
        while j < B!.count && A![i] > B![j] {
            j += 1
        }
        result += j
    }

    print(result)
}
