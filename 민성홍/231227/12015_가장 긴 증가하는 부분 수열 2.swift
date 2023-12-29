//
//  main.swift
//  BackjoonUangel
//
//  Created by 민성홍 on 12/27/23.
//  백준 12015: 가장 긴 증가하는 부분 수열2
//  메모리: 144704 KB
//  시간: 492 ms

import Foundation

let N = Int(readLine()!)!
let A = readLine()!.split(separator: " ").map { Int($0)! }

var lis: [Int] = []

for i in 0..<N {
    if lis.isEmpty || lis.last! < A[i] {
        lis.append(A[i])
    } else {
        var left = 0
        var right = lis.count - 1

        while left < right {
            let mid = (left + right) / 2

            if lis[mid] < A[i] {
                left = mid + 1
            } else {
                right = mid
            }
        }

        lis[right] = A[i]
    }
}

print(lis.count)
